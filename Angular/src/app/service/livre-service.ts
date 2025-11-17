import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { LivreDto } from '../dto/livre-dto';

@Injectable({
  providedIn: 'root',
})
export class LivreService {
  
  private apiUrl: string = '/livres';
  private refresh$: Subject<void> = new Subject<void>();

  constructor(private http: HttpClient) {}

  public findAll(): Observable<LivreDto[]> {
    return this.http.get<LivreDto[]>(this.apiUrl);
  }

  public findById(id: number): Observable<LivreDto> {
    return this.http.get<LivreDto>(`${this.apiUrl}/${id}`);
  }

  public refresh() {
    this.refresh$.next();
  }

  public save(livre: LivreDto): void {
    const payload = livre.toJson();
    if (!livre.id) {
      this.http.post<LivreDto>(this.apiUrl, payload).subscribe(() => this.refresh());
    }
    else {
      this.http.put<LivreDto>(`${this.apiUrl}/${livre.id}`, payload).subscribe(() => this.refresh());
    }
  }

  public deleteById(id: number): void {
    this.http.delete<void>(`${this.apiUrl}/${id}`).subscribe(() => this.refresh());
  }
}
