import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router, RouterLink } from "@angular/router";
import { Categoria } from "../categoria.model";
import { CategoriaService } from "../categoria.service";

@Component({
  selector: "app-categoria-update",
  templateUrl: "./categoria-update.component.html",
  styleUrls: ["./categoria-update.component.css"],
})
export class CategoriaUpdateComponent implements OnInit {
  categoria: Categoria = {
    id: "",
    name: "",
    description: "",
  };

  constructor(
    private service: CategoriaService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.categoria.id = this.route.snapshot.paramMap.get("id")!;
    this.findById();
  }

  findById(): void {
    this.service.findById(this.categoria.id!).subscribe(
      (resposta) => {
        this.categoria.name = resposta.name;
        this.categoria.description = resposta.description;
      },
      (err) => {
        this.service.mensagem(err.error.error);
        this.router.navigate(["categorias"]);
      }
    );
  }

  cancel(): void {
    this.router.navigate(["categorias"]);
  }

  update(): void {
    this.service.update(this.categoria).subscribe(
      (resposta) => {
        this.router.navigate(["categorias"]);
        this.service.mensagem("Categoria Atualizada com sucesso!");
      },
      (err) => {
        for (let i = 0; i < err.error.erros.length; i++) {
          this.service.mensagem(err.error.erros[i].message);
        }
      }
    );
  }
}
