import { Component, OnInit } from '@angular/core';
import { StockService } from '../stock.service';
import { SharedDataServiceService } from '../shared-data-service.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  constructor( private stockService: StockService, private sharedDataServiceService:SharedDataServiceService ) { }
  stocks: any[] = [];
  pageSize = 5; // Number of items per page
  currentPage = 1;
  totalInvestment: any;
  totalRemainingQuantity: any;
  totalQuantity: any;
  totalSale: any;
  profit_Loss: any;
  ngOnInit(): void {
    this.loadStock();
  }


  loadStock(): void {
    this.stockService.getStock().subscribe(data => {
      this.stocks = data;
      this.totalInvestment=
      data.reduce(
        (accumulator, product) =>{return accumulator + product.costPrice * product.quantity},
        0
    );
    this.totalRemainingQuantity=  data.reduce(
      (accumulator, product) => accumulator + product.remainingQuantity,
      0
  );
  this.totalQuantity=  data.reduce(
    (accumulator, product) => accumulator + product.quantity,
    0
);
this.totalSale=  data.reduce(
  (accumulator, product) => accumulator + product.totalSale,
  0
);
this.profit_Loss=this.totalSale-this.totalInvestment;
    });
  }

  getDisplayedstocks(): any[] {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    return this.stocks.slice(startIndex, endIndex);
  }

  onPageChange(event: any): void {
    this.currentPage = event.pageIndex + 1;
  }
}
