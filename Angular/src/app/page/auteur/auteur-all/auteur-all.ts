import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AuteurDto } from '../../../dto/auteur-dto';
import { AuteurService } from '../../../service/auteur-service';
import { Observable } from 'rxjs';
import { ImplicitReceiver } from '@angular/compiler';
import { FormBuilder, FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-auteur-all',
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './auteur-all.html',
  styleUrl: './auteur-all.css',
})
export class AuteurAll implements OnInit{
  protected auteurs$!: Observable<AuteurDto[]>;
  protected auteurForm!: FormGroup;
  protected nomCtrl!: FormControl;
  protected prenomCtrl!: FormControl;
  protected nationaliteCtrl!: FormControl;

  protected editingAuteur!: AuteurDto | null;


  constructor(
    private auteurService: AuteurService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.auteurs$ = this.auteurService.findAll();

    this.nomCtrl = this.formBuilder.control('', Validators.required);
    this.prenomCtrl = this.formBuilder.control('', Validators.required);
    this.nationaliteCtrl = this.formBuilder.control('', Validators.required);
    
    this.auteurForm = this.formBuilder.group({
      nom: this.nomCtrl,
      prenom: this.prenomCtrl,
      nationalite: this.nationaliteCtrl
    });
  }

  public trackAuteur(index: number, value: AuteurDto) {
    return value.id;
  }
  
  public createOrModifyAuteur(): void {
      if (this.auteurForm.invalid) {
        this.auteurForm.markAllAsTouched();
        return;
      }
  
      const formValue = this.auteurForm.value;
  
      let dto: AuteurDto;
  
      
      if (this.editingAuteur) {
        // modification
        dto = new AuteurDto(
          this.editingAuteur.id,
          formValue.nom,
          formValue.prenom,
          formValue.nationalite,
        );
      } else {
        // création
        dto = new AuteurDto(
          0,
          formValue.nom,
          formValue.prenom,
          formValue.nationalite,
        );
      }
  
      this.auteurService.save(dto);
      this.editingAuteur = null;
      this.auteurForm.reset();
      this.auteurs$ = this.auteurService.findAll(); 
    }
  
    public modify(auteur: AuteurDto) {
      this.editingAuteur = auteur;
  
      this.auteurForm.patchValue({
        nom: auteur.nom,
        prenom:auteur.prenom,
        nationalite: auteur.nationalite,
      });
    }
  
    public deleteAuteur(auteur: AuteurDto): void {
      this.auteurService.deleteById(auteur.id);
      this.auteurs$ = this.auteurService.findAll(); 
    }
}
