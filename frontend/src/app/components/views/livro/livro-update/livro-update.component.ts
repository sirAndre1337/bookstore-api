import { Component, OnInit } from "@angular/core";
import { FormControl, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Livro } from "../livro.model";
import { LivroService } from "../livro.service";

@Component({
  selector: "app-livro-update",
  templateUrl: "./livro-update.component.html",
  styleUrls: ["./livro-update.component.css"],
})
export class LivroUpdateComponent implements OnInit {
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
    this.livro.id = this.router.snapshot.paramMap.get("id")!;
    this.findLivroById();
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

  cancel(): void {
    this.route.navigate([`categorias/${this.id_categoria}/livros`]);
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

  update(): void {
    this.service.update(this.livro).subscribe(
      (resposta) => {
        this.route.navigate([`categorias/${this.id_categoria}/livros`]);
        this.service.mensagem("Livro atualizado com sucesso!");
      },
      (err) => {
        this.service.mensagem(
          "Erro ao atualizar o livro! motivo: " + err.error.error
        );
      }
    );
  }
}
