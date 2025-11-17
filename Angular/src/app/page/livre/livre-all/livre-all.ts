import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LivreDto } from '../../../dto/livre-dto';
import { FormGroup, FormControl, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Observable } from 'rxjs';
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

  protected livreForm!: FormGroup;
  protected titreCtrl!: FormControl;
  protected resumerCtrl!: FormControl;
  protected anneeCtrl!: FormControl;
  protected auteurCtrl!: FormControl;
  protected editeurCtrl!: FormControl;
  protected collectionCtrl!: FormControl;

  protected editingLivre!: LivreDto | null;

  constructor(
    private livreService: LivreService, 
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.reloadLivres();

    this.titreCtrl = this.formBuilder.control('', Validators.required);
    this.resumerCtrl = this.formBuilder.control('', [Validators.required, Validators.maxLength(500)]);
    this.anneeCtrl = this.formBuilder.control('', [Validators.required, Validators.minLength(4), Validators.maxLength(4)]);
    this.auteurCtrl = this.formBuilder.control(null);
    this.editeurCtrl = this.formBuilder.control(null);
    this.collectionCtrl = this.formBuilder.control(null);

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

  private reloadLivres(): void {
    this.livres$ = this.livreService.findAll();
  }

  public creerOuModifierLivre(): void {
    if (this.livreForm.invalid) {
      this.livreForm.markAllAsTouched();
      return;
    }

    const formValue = this.livreForm.value;

    let dto: LivreDto;

    if (this.editingLivre) {
      // modification
      dto = new LivreDto(
        this.editingLivre.id,
        formValue.titre,
        formValue.resumer,
        formValue.annee,
        formValue.auteur ?? this.editingLivre.auteur,
        formValue.editeur ?? this.editingLivre.editeur,
        formValue.collection ?? this.editingLivre.collection
      );
    } else {
      // création
      dto = new LivreDto(
        0,
        formValue.titre,
        formValue.resumer,
        formValue.annee,
        formValue.auteur ?? null,
        formValue.editeur ?? null,
        formValue.collection ?? null
      );
    }

    this.livreService.save(dto);
    this.editingLivre = null;
    this.livreForm.reset();
    this.reloadLivres(); 
  }

  public editer(livre: LivreDto) {
    this.editingLivre = livre;

    this.livreForm.patchValue({
      titre: livre.titre,
      resumer: livre.resumer,
      annee: livre.annee,
      auteur: livre.auteur,
      editeur: livre.editeur,
      collection: livre.collection
    });
  }

  public supprimerLivre(livre: LivreDto): void {
    this.livreService.deleteById(livre.id);
    this.reloadLivres();
  }
}
