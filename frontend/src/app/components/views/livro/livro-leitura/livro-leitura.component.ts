import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Livro } from "../livro.model";
import { LivroService } from "../livro.service";

@Component({
  selector: "app-livro-leitura",
  templateUrl: "./livro-leitura.component.html",
  styleUrls: ["./livro-leitura.component.css"],
})
export class LivroLeituraComponent implements OnInit {
  id_categoria: String = "";

  livro: Livro = {
    id: "",
    title: "",
    name_author: "",
    text: "",
  };

  constructor(
    private service: LivroService,
    private router: ActivatedRoute,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.id_categoria = this.router.snapshot.paramMap.get("id_cat")!;
    this.livro.id = this.router.snapshot.paramMap.get("id")!;
    this.findLivroById();
  }

  findLivroById(): void {
    this.service.findById(this.livro.id!).subscribe(
      (resposta) => {
        this.livro = resposta;
      },
      (err) => {
        this.route.navigate([`categorias/${this.id_categoria}/livros`]);
        this.service.mensagem(
          "Erro ao carregar livro! motivo: " + err.error.error
        );
      }
    );
  }
  cancel(): void {
    this.route.navigate([`categorias/${this.id_categoria}/livros`]);
  }
}
