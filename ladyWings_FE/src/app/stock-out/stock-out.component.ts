import { Component, OnInit } from '@angular/core';
import { SharedDataServiceService } from '../shared-data-service.service';
import { StockService } from '../stock.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-stock-out',
  templateUrl: './stock-out.component.html',
  styleUrls: ['./stock-out.component.css']
})
export class StockOutComponent implements OnInit {

  constructor( private stockService: StockService,private snackBar: MatSnackBar,
     private sharedDataServiceService:SharedDataServiceService ) { }
  stocks: any[] = [];
  stock: any = this.sharedDataServiceService.getDefaultStock();
  saleQuantity: any;
  soldPrice:any;

  ngOnInit(): void {

  }

  loadStockById(): void {
    this.stockService.getStockByID(this.stock.id).subscribe(data => {
      this.stocks = Array.isArray(data) ? data : [data];
    });
  }

  getDisplayedstocks(): any[] {
    return this.stocks;
  }


  updateStockById() {
    this.stock = this.stocks[0];
   if(this.stock.remainingQuantity>0){
    this.stock.remainingQuantity=this.stock.remainingQuantity-this.saleQuantity;
    this.stock.previousSoldPrice= this.stock.previousSoldPrice !=null ?this.soldPrice : 0;
    this.stock.totalSale= this.stock.previousSoldPrice !=null ?this.soldPrice : 0;
    this.stockService.updateStockById(this.stock,this.stock.id).subscribe(response => {
      this.snackBar.open('Stock updated successfully!', 'Close', {
        duration: 3000, // Duration in milliseconds
      });
    });
  }else{
    this.snackBar.open('Stock quantity not available ', 'Close', {
      duration: 3000, // Duration in milliseconds
    });
  }
  }

}
