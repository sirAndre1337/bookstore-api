import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { timeout } from "rxjs";
import { Categoria } from "../categoria.model";
import { CategoriaService } from "../categoria.service";

@Component({
  selector: "app-categoria-read",
  templateUrl: "./categoria-read.component.html",
  styleUrls: ["./categoria-read.component.css"],
})
export class CategoriaReadComponent implements OnInit {
  categorias: Categoria[] = [];

  displayedColumns: string[] = ["id", "name", "description", "books", "action"];

  constructor(private service: CategoriaService, private router: Router) {}

  ngOnInit(): void {
    this.findall();
  }

  findall() {
    this.service.findall().subscribe((resposta) => {
      console.log(resposta);
      this.categorias = resposta;
    });
  }

  navegarParaCategoriaCreate() {
    this.router.navigate(["categorias/create"]);
  }

  deleteCategory(id: String) {
    this.service.delete(id).subscribe(
      (resposta) => {
        this.router.navigate(["/"]);
        this.service.mensagem("Categoria deleta com sucesso!");
        setTimeout(() => {
          this.router.navigate(["categorias"]);
        }, 1);
      },
      (err) => {
        this.service.mensagem(err.error.error);
      }
    );
  }
}
