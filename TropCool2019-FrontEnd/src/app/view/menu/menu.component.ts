import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { matExpansionAnimations, MatExpansionPanelState } from '@angular/material';
import { Subscription } from 'rxjs';

/**
 *
 */
@Component({
  selector: 'menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
  animations: [
    matExpansionAnimations.bodyExpansion,
    matExpansionAnimations.indicatorRotate,
  ],
})
export class MenuComponent implements OnInit
{
  /**
   *
   */
  @Input()
  public sidenav: any;

  /**
   *
   */
  @Output()
  public onToogle: EventEmitter<any> = new EventEmitter();

  /**
   *
   */
  public menuGroups: any[] = [];

  /**
   *
   */
  private userSubscription: Subscription;

  /**
   *
   */
  constructor() { }

  /**
   *
   */
  ngOnInit()
  {
    this.createMenu();
  }

  /**
   *
   */
  ngOnChanges()
  {
    this.createMenu();
  }

  /**
   *
   */
  public createMenu()
  {
    this.menuGroups = [
      /*
        {
          label: "Listar",
          menuList: [
            { icon: 'event', label: 'Configuracao-Agenda', routerlink: 'configuracoes'}
          ],
          open: false
        },
        {
          label: "Cadastros",
          menuList: [
            { icon: 'event', label: 'Configuracao-Agenda', routerlink: 'configuracoes/cadastrar'}
          ],
          open: false
        } */
        {
          label: "Configuração Agenda",
          menuList: [
            { icon: 'event', label: 'Listar', routerlink: 'configuracoes'},
            { icon: 'event', label: 'Cadastrar', routerlink: 'configuracoes/cadastrar'}
          ],
          open: false
        }
      ]

    this.removeEmptyItens();
  }

  /**
   *
   */
  removeEmptyItens()
  {
    this.menuGroups = this.menuGroups.filter((menuItem) => menuItem != null);
    this.menuGroups.forEach((menuItem) => menuItem.menuList = menuItem.menuList.filter((menuListItem) => menuListItem != null));
  }

  /**
   *
   */
  ngOnDestroy()
  {
    this.userSubscription.unsubscribe();
  }

  /** Gets the expanded state string. */
  getExpandedState(menuGroup): MatExpansionPanelState {
    return menuGroup.open ? 'expanded' : 'collapsed';
  }
}
