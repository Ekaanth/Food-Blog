import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DraftarticlepublishComponent } from './draftarticlepublish.component';

describe('DraftarticlepublishComponent', () => {
  let component: DraftarticlepublishComponent;
  let fixture: ComponentFixture<DraftarticlepublishComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DraftarticlepublishComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DraftarticlepublishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
