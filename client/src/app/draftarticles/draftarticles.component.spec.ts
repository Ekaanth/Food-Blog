import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DraftarticlesComponent } from './draftarticles.component';

describe('DraftarticlesComponent', () => {
  let component: DraftarticlesComponent;
  let fixture: ComponentFixture<DraftarticlesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DraftarticlesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DraftarticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
