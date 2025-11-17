import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { EditeurDto } from '../../../dto/editeur-dto';
import { EditeurService } from '../../../service/editeur-service';
import { Observable } from 'rxjs';
import { FormGroup, FormControl, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';


@Component({
  selector: 'app-editeur-all',
  imports: [ CommonModule, ReactiveFormsModule],
  templateUrl: './editeur-all.html',
  styleUrl: './editeur-all.css',
})

export class EditeurAll implements OnInit{
  protected editeurs$!: Observable<EditeurDto[]>;

  protected editeurForm!: FormGroup;
  protected nomCtrl!: FormControl
  protected paysCtrl!: FormControl;

  protected editingEditeur!: EditeurDto | null;

  constructor(
    private editeurService: EditeurService, 
    private formBuilder: FormBuilder) { }
  
  ngOnInit(): void {
    this.reloadEditeurs();

    this.nomCtrl = this.formBuilder.control('', Validators.required);
    this.paysCtrl = this.formBuilder.control('', Validators.required);
    this.editeurForm = this.formBuilder.group({
      nom: this.nomCtrl,
      pays: this.paysCtrl
    });
  }

  public trackEditeur(index: number, value: EditeurDto) {
    return value.id;
  }

  private reloadEditeurs(): void {
    this.editeurs$ = this.editeurService.findAll();
  }

  public createOrModifyEditeur(): void {
    if (this.editeurForm.invalid) {
      return;
    }
    
    const formValue = this.editeurForm.value;

    let dto : EditeurDto;
    if (this.editingEditeur) {
      dto = new EditeurDto(
        this.editingEditeur.id,
        formValue.nom,
        formValue.pays
      );
    } else {
      dto = new EditeurDto(
        0,
        formValue.nom,
        formValue.pays
      );
    }

    this.editeurService.save(dto);
    this.editingEditeur = null;
    this.editeurForm.reset();
    this.reloadEditeurs();
  }

  public editEditeur(editeur: EditeurDto): void {
    this.editingEditeur = editeur;
    this.editeurForm.patchValue({
      nom: editeur.nom,
      pays: editeur.pays
    });
  }

  public deleteEditeur(id: number): void {
    this.editeurService.deleteById(id);
    this.reloadEditeurs();
  }



}
