import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { GenericArchiveComponent } from './genericarchive.component';


describe('GenericArchiveComponent', () => {
  let component: GenericArchiveComponent;
  let fixture: ComponentFixture<GenericArchiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenericArchiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenericArchiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
