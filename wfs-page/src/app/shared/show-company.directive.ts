import {Directive, Input, OnInit, TemplateRef, ViewContainerRef} from '@angular/core';
import {UserService} from '../core/services/user.service';

@Directive({selector: '[appShowCompany]'})
export class ShowCompanyDirective implements OnInit {

  constructor(
    private templateRef: TemplateRef<any>,
    private userService: UserService,
    private viewContainer: ViewContainerRef
  ) {}

  condition: boolean;

  ngOnInit(): void {
      this.userService.isEmployed.subscribe(
        (isEmployed) => {
          if (isEmployed && this.condition || !isEmployed && !this.condition) {
            this.viewContainer.createEmbeddedView(this.templateRef);
          } else {
            this.viewContainer.clear();
          }
        }
      );
  }
  @Input() set appShowCompany(condition: boolean) {
    this.condition = condition;
  }
}
