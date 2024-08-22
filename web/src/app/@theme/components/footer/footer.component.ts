import {Component} from '@angular/core';

@Component({
  selector: 'ngx-footer',
  styleUrls: ['./footer.component.scss'],
  template: `
    <span class="created-by">Projet Vanilla - Test technique EDF d'après le projet de <b><a href="https://akveo.com" target="_blank">Akveo</a></b></span>
  `,
})
export class FooterComponent {
}
