import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FiveArticlesComponent } from './fivearticles.component';


describe('FiveArticlesComponent', () => {
  let component: FiveArticlesComponent;
  let fixture: ComponentFixture<FiveArticlesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FiveArticlesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FiveArticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
