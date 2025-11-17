import { Component } from '@angular/core';
import { CollectionService } from '../../service/collection-service';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { CollectionDto } from '../../dto/collection-dto';
import { Observable } from 'rxjs';

@Component({
  selector: 'collection',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './collection.html',
  styleUrl: './collection.css',
})
export class Collection {

  protected collections$!:Observable<CollectionDto[]>
  protected collectionForm!: FormGroup;

  protected idCtrl!: FormControl;
  protected nomCtrl!: FormControl;


  constructor(private collectionService: CollectionService, private formBuilder: FormBuilder) { }

ngOnInit () : void {

  this.collections$=this.collectionService.findAll();

    this.idCtrl = this.formBuilder.control('');
    this.nomCtrl = this.formBuilder.control('');

    this.collectionForm = this.formBuilder.group({
      id: this.idCtrl,
      password: this.nomCtrl
    });
}

public creerModif() {
  this.collectionService.save(new CollectionDto(this.idCtrl.value, this.nomCtrl.value));
}

 public supprimer(collection: CollectionDto) {
    this.collectionService.deleteById(collection.id);
  }
}
