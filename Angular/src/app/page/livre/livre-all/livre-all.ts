// livre-all.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormGroup, FormControl, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Observable } from 'rxjs';
import { AuteurDto } from '../../../dto/auteur-dto';
import { CollectionDto } from '../../../dto/collection-dto';
import { EditeurDto } from '../../../dto/editeur-dto';
import { LivreDto } from '../../../dto/livre-dto';
import { AuteurService } from '../../../service/auteur-service';
import { CollectionService } from '../../../service/collection-service';
import { EditeurService } from '../../../service/editeur-service';
import { LivreService } from '../../../service/livre-service';
@Component({
  selector: 'app-livre-all',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './livre-all.html',
  styleUrl: './livre-all.css',
})
export class LivreAll implements OnInit {

  protected livres$!: Observable<LivreDto[]>;
  protected auteurs$!: Observable<AuteurDto[]>;
  protected editeurs$!: Observable<EditeurDto[]>;
  protected collections$!: Observable<CollectionDto[]>;

  protected livreForm!: FormGroup;
  protected titreCtrl!: FormControl;
  protected resumerCtrl!: FormControl;
  protected anneeCtrl!: FormControl;
  protected auteurCtrl!: FormControl;
  protected editeurCtrl!: FormControl;
  protected collectionCtrl!: FormControl;

  protected editingLivre: LivreDto | null = null;

  constructor(
    private livreService: LivreService,
    private auteurService: AuteurService,
    private editeurService: EditeurService,
    private collectionService: CollectionService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.livres$ = this.livreService.findAll();
    this.auteurs$ = this.auteurService.findAll();
    this.editeurs$ = this.editeurService.findAll();
    this.collections$ = this.collectionService.findAll();

    this.titreCtrl = this.formBuilder.control('', Validators.required);
    this.resumerCtrl = this.formBuilder.control('', [Validators.required, Validators.maxLength(500)]);
    this.anneeCtrl = this.formBuilder.control('', [Validators.required, Validators.minLength(4), Validators.maxLength(4)]);

    this.auteurCtrl = this.formBuilder.control<AuteurDto | null>(null, Validators.required);
    this.editeurCtrl = this.formBuilder.control<EditeurDto | null>(null, Validators.required);
    this.collectionCtrl = this.formBuilder.control<CollectionDto | null>(null);

    this.livreForm = this.formBuilder.group({
      titre: this.titreCtrl,
      resumer: this.resumerCtrl,
      annee: this.anneeCtrl,
      auteur: this.auteurCtrl,
      editeur: this.editeurCtrl,
      collection: this.collectionCtrl
    });
  }

  public trackLivre(index: number, value: LivreDto) {
    return value.id;
  }

  public trackAuteur(index: number, value: AuteurDto) {
    return value.id;
  }

  public trackEditeur(index: number, value: EditeurDto) {
    return value.id;
  }

  public trackCollection(index: number, value: CollectionDto) {
    return value.id;
  }

  public creerOuModifierLivre(): void {
    if (this.livreForm.invalid) {
      this.livreForm.markAllAsTouched();
      return;
    }

    const formValue = this.livreForm.value;

    const auteur: AuteurDto | null = formValue.auteur ?? null;
    const editeur: EditeurDto | null = formValue.editeur ?? null;
    const collection: CollectionDto | null = formValue.collection ?? null;

    let dto: LivreDto;

    if (this.editingLivre) {
      // modification
      dto = new LivreDto(
        this.editingLivre.id,
        formValue.titre,
        formValue.resumer,
        formValue.annee,
        auteur ?? this.editingLivre.auteur,
        editeur ?? this.editingLivre.editeur,
        collection ?? this.editingLivre.collection ?? null
      );
    } else {
      // création
      dto = new LivreDto(
        0,
        formValue.titre,
        formValue.resumer,
        formValue.annee,
        auteur,
        editeur,
        collection
      );
    }

    this.livreService.save(dto);
    this.editingLivre = null;
    this.livreForm.reset();
  }

  public editer(livre: LivreDto) {
    this.editingLivre = livre;

    this.livreForm.patchValue({
      titre: livre.titre,
      resumer: livre.resumer,
      annee: livre.annee,
      auteur: livre.auteur ?? null,
      editeur: livre.editeur ?? null,
      collection: livre.collection ?? null
    });
  }

  public supprimerLivre(livre: LivreDto): void {
    this.livreService.deleteById(livre.id);
  }
}
