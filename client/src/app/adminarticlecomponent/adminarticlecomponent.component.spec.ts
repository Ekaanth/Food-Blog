import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminarticlecomponentComponent } from './adminarticlecomponent.component';

describe('AdminarticlecomponentComponent', () => {
  let component: AdminarticlecomponentComponent;
  let fixture: ComponentFixture<AdminarticlecomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminarticlecomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminarticlecomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
