import { Component, OnInit } from "@angular/core";
import { FormControl, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Livro } from "../livro.model";
import { LivroService } from "../livro.service";

@Component({
  selector: "app-livro-create",
  templateUrl: "./livro-create.component.html",
  styleUrls: ["./livro-create.component.css"],
})
export class LivroCreateComponent implements OnInit {
  titulo = new FormControl("", [Validators.minLength(3)]);
  nome_author = new FormControl("", [Validators.minLength(3)]);
  texto = new FormControl("", [Validators.minLength(10)]);
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
  }

  getMessage() {
    if (this.titulo.invalid) {
      return "O campo Titulo deve conter entre 3 e 100 caracteres ";
    }
    if (this.nome_author.invalid) {
      return "O campo Nome do author deve conter entre 3 e 100 caracteres ";
    }
    if (this.texto.invalid) {
      return "O campo Texto deve conter entre 10 e 2000000 caracteres ";
    }
    return false;
  }

  create(): void {
    this.service.create(this.id_categoria, this.livro).subscribe(
      (resposta) => {
        this.route.navigate([`categorias/${this.id_categoria}/livros`]);
        this.service.mensagem("Livro criado com sucesso!");
      },
      (err) => {
        this.route.navigate([`categorias/${this.id_categoria}/livros`]);
        this.service.mensagem("Erro ao criar novo livro! Contante o dev André");
      }
    );
  }
  cancel(): void {
    this.route.navigate([`categorias/${this.id_categoria}/livros`]);
  }
}
