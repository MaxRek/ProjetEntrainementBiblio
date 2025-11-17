import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, startWith, Subject, switchMap } from 'rxjs';
import { AuteurDto } from '../dto/auteur-dto';

@Injectable({
  providedIn: 'root',
})
export class AuteurService {
  private apiUrl: string = "http://localhost:8080/api/auteur";
  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) {}

  public findAll(): Observable<AuteurDto[]> {
    return this.refresh$.pipe(
      startWith(null),

      switchMap(()=> {
        return this.http.get<AuteurDto[]>(this.apiUrl);
      })
    )
  }

}
