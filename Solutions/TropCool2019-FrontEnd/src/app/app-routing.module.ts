import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConfiguracaoSearchComponent } from './view/configuracao-agenda/configuracao-search/configuracao-search.component';
import { ConfiguracaoFormComponent } from './view/configuracao-agenda/configuracao-form/configuracao-form.component';
import { ConfiguracaoDetailComponent } from './view/configuracao-agenda/configuracao-detail/configuracao-detail.component';


const routes: Routes = [  
  {
    component:ConfiguracaoSearchComponent,
    path:'configuracoes'  
  }, 
  {
    component: ConfiguracaoFormComponent,
    path: 'configuracoes/cadastrar'
  },
  {
    component: ConfiguracaoFormComponent,
    path: 'configuracoes/alterar/:id'
  },
  {
    component: ConfiguracaoDetailComponent,
    path: 'configuracoes/detalhes/:id'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
