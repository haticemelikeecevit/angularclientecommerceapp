import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories:any = [];

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getCategories();
  }

  getCategories() {
    this.categories = [];
    this.rest.getCategories().subscribe((data: {}) => {
      console.log(data);
      this.categories = data;
    });
  }

  add() {
    this.router.navigate(['/category-add']);
  }

  delete(id) {
    this.rest.deleteProduct(id)
      .subscribe(res => {
          this.getCategories();
        }, (err) => {
          console.log(err);
        }
      );
  }

}
