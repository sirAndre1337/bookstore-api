import { Component, OnInit } from "@angular/core";
import { Categoria } from "./categoria.model";
import { CategoriaService } from "./categoria.service";

@Component({
  selector: "app-categoria-read",
  templateUrl: "./categoria-read.component.html",
  styleUrls: ["./categoria-read.component.css"],
})
export class CategoriaReadComponent implements OnInit {
  categorias: Categoria[] = [];

  displayedColumns: string[] = ["id", "name", "description", "books" , "action"];

  constructor(private service: CategoriaService) {}

  ngOnInit(): void {
    this.findall();
  }

  findall() {
    this.service.findall().subscribe((resposta) => {
      console.log(resposta);
      this.categorias = resposta;
    });
  }
}
