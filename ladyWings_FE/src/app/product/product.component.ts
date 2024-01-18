import { Component,OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SharedDataServiceService } from '../shared-data-service.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  constructor(private productService: ProductService,private snackBar: MatSnackBar
    ,private  sharedDataServiceService:SharedDataServiceService) { }
  product = this.sharedDataServiceService.getDefaultProduct();
  products: any[] = [];
  pageSize = 5; // Number of items per page
  currentPage = 1;
 
  getDisplayedProducts(): any[] {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    return this.products.slice(startIndex, endIndex);
  }

  onPageChange(event: any): void {
    this.currentPage = event.pageIndex + 1;
  }

  ngOnInit(): void {
    this.productService.getProducts().subscribe(data => {
      this.products = data;
      console.log('Products received:', this.products);
    });
  }

  submitForm() {
    this.productService.addProduct([this.product]).subscribe(response => {
      console.log('Product added successfully');
      this.snackBar.open('Product added successfully!', 'Close', {
        duration: 3000, // Duration in milliseconds
      });
      this.loadProducts();
      // You can update UI or perform other actions on successful addition
    });
  }
  deleteProduct(productId: number): void {
    this.productService.deleteProduct(productId).subscribe(() => {
      // Assuming you want to refresh the product list after deletion
      this.snackBar.open('Product deleted successfully!', 'Close', {
        duration: 3000, // Duration in milliseconds
      });
      this.loadProducts();
    });
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe(data => {
      this.products = data;
    });
  }

}
