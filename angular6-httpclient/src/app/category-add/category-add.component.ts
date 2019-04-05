import { Component, OnInit, Input } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.css']
})
export class CategoryAddComponent implements OnInit {

  @Input() categoryData = { name:'' };

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  addCategory() {
    this.rest.addCategory(this.categoryData).subscribe((result) => {
      this.router.navigate(['/categories']);
    }, (err) => {
      console.log(err);
    });
  }

}
