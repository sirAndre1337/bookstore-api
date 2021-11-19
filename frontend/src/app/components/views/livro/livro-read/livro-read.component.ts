import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Livro } from "../livro.model";
import { LivroService } from "../livro.service";

@Component({
  selector: "app-livro-read",
  templateUrl: "./livro-read.component.html",
  styleUrls: ["./livro-read.component.css"],
})
export class LivroReadComponent implements OnInit {
  livros: Livro[] = [];
  id_categoria: String = "";

  displayedColumns: string[] = ["id", "title", "livros", "action"];
  constructor(
    private service: LivroService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id_categoria = this.route.snapshot.paramMap.get("id_cat")!;
    this.findAll();
  }

  findAll(): void {
    this.service.findAllByCategoria(this.id_categoria).subscribe((resposta) => {
      this.livros = resposta;
    });
  }

  criarLivro(): void {
    this.router.navigate([`categorias/${this.id_categoria}/livros/create`]);
  }
}
