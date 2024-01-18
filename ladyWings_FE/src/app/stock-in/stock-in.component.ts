import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { VendorService } from '../vendor.service';
import { StockService } from '../stock.service';
import { FormControl, Validators } from '@angular/forms';
import { SharedDataServiceService } from '../shared-data-service.service';


@Component({
  selector: 'app-stock-in',
  templateUrl: './stock-in.component.html',
  styleUrls: ['./stock-in.component.css']
})
export class StockInComponent implements OnInit {

  
  constructor(private productService: ProductService,private snackBar: MatSnackBar,
    private vendorService: VendorService, private stockService: StockService,
    private sharedDataServiceService:SharedDataServiceService) { }
  products: any[] = [];
  vendors: any[] = [];
  stocks: any[] = [];
  
  stock: any = this.sharedDataServiceService.getDefaultStock();
    costPriceFormControl = new FormControl('', [
      Validators.required,
      Validators.pattern(/^\d+(\.\d{1,2})?$/)
    
    ]);

    quantityFormControl = new FormControl('',[
      Validators.required,
      Validators.pattern(/^\d+$/),
    ])

  ngOnInit(): void {
    this.loadProducts();
    this.loadVendors();
  }

  addStock() {
    this.stockService.addStock([this.stock]).subscribe(response => {
      this.snackBar.open('Stock added successfully!', 'Close', {
        duration: 3000, // Duration in milliseconds
      });
    });
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe(data => {
      this.products = data;
    });
  }

  loadVendors(): void {
    this.vendorService.getVendors().subscribe((data) => {
      this.vendors = data;
    });
  }

  calculateTotal(): void {
    const costPrice = parseFloat(this.stock.costPrice);
    const quantity = parseFloat(this.stock.quantity);
    this.stock.remainingQuantity=this.stock.quantity;

    if (!isNaN(costPrice) && !isNaN(quantity) && quantity !== 0) {
      this.stock.productTotal = (costPrice * quantity).toFixed(2);
    } else {
      this.stock.productTotal = 0;
    }
  }
}
