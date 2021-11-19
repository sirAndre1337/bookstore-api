import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Livro } from "./livro.model";

@Injectable({
  providedIn: "root",
})
export class LivroService {
  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private _snack: MatSnackBar) {}

  findAllByCategoria(id_categoria: String): Observable<Livro[]> {
    const url = `${this.baseUrl}/book?category=${id_categoria}`;
    return this.http.get<Livro[]>(url);
  }

  create(id_categoria: String, livro: Livro): Observable<Livro> {
    const url = `${this.baseUrl}/book?category=${id_categoria}`;
    return this.http.post<Livro>(url, livro);
  }

  findById(id_book: String): Observable<Livro> {
    const url = `${this.baseUrl}/book/${id_book}`;
    return this.http.get<Livro>(url);
  }

  update(livro: Livro): Observable<Livro> {
    const url = `${this.baseUrl}/book/${livro.id}`;
    return this.http.put<Livro>(url, livro);
  }

  mensagem(str: String): void {
    this._snack.open(`${str}`, "OK", {
      horizontalPosition: "end",
      verticalPosition: "top",
      duration: 3000,
    });
  }
}
