import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationUnsignedComponent } from './navigation-unsigned.component';

describe('NavigationComponent', () => {
  let component: NavigationUnsignedComponent;
  let fixture: ComponentFixture<NavigationUnsignedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavigationUnsignedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigationUnsignedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
