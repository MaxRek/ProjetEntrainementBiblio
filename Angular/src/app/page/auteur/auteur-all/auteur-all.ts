import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AuteurDto } from '../../../dto/auteur-dto';
import { AuteurService } from '../../../service/auteur-service';
import { Observable } from 'rxjs';
import { ImplicitReceiver } from '@angular/compiler';

@Component({
  selector: 'app-auteur-all',
  imports: [CommonModule],
  templateUrl: './auteur-all.html',
  styleUrl: './auteur-all.css',
})
export class AuteurAll implements OnInit{
  protected auteurs$!: Observable<AuteurDto[]>;

  constructor(private auteurService: AuteurService) { }

  ngOnInit(): void {
    this.auteurs$ = this.auteurService.findAll();
  }

  /*public trackAuteur(index: number, value: AuteurDto) {
    return value.id;
  }*/
}
