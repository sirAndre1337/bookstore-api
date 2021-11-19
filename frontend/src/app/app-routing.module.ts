import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CategoriaCreateComponent } from "./components/views/categoria/categoria-create/categoria-create.component";
import { CategoriaReadComponent } from "./components/views/categoria/categoria-read/categoria-read.component";
import { CategoriaUpdateComponent } from "./components/views/categoria/categoria-update/categoria-update.component";
import { HomeComponent } from "./components/views/home/home.component";
import { LivroCreateComponent } from "./components/views/livro/livro-create/livro-create.component";
import { LivroLeituraComponent } from "./components/views/livro/livro-leitura/livro-leitura.component";
import { LivroReadComponent } from "./components/views/livro/livro-read/livro-read.component";
import { LivroUpdateComponent } from "./components/views/livro/livro-update/livro-update.component";

const routes: Routes = [
  {
    path: "",
    component: HomeComponent,
  },
  {
    path: "categorias",
    component: CategoriaReadComponent,
  },
  {
    path: "categorias/create",
    component: CategoriaCreateComponent,
  },
  {
    path: "categorias/update/:id",
    component: CategoriaUpdateComponent
  },
  {
    path: "categorias/:id_cat/livros",
    component: LivroReadComponent
  },
  {
    path:"categorias/:id_cat/livros/create",
    component: LivroCreateComponent
  },
  {
    path:"categorias/:id_cat/livros/:id/update",
    component: LivroUpdateComponent
  },
  {
    path:"categorias/:id_cat/livros/:id/read",
    component:LivroLeituraComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
