import { Component, OnInit } from '@angular/core';
import { SharedDataServiceService } from '../shared-data-service.service';
import { MaintenanceService } from '../maintenance.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-maintenance',
  templateUrl: './maintenance.component.html',
  styleUrls: ['./maintenance.component.css']
})
export class MaintenanceComponent implements OnInit {

  constructor( private sharedDataServiceService:SharedDataServiceService, private maintenanaceService:MaintenanceService,
    private snackBar: MatSnackBar) { }
  bills = this.sharedDataServiceService.getDefaultBills();
  billsData:any[] =[];
  pageSize = 5; // Number of items per page
  currentPage = 1;
  ngOnInit(): void {
    this.loadBills();
  }
  
  loadBills(): void {
    this.maintenanaceService.getBills().subscribe(data => {
      this.billsData = data;
    });
  }

  CreateBill(){
    this.maintenanaceService.addBills([this.bills]).subscribe(response => {
      console.log('Bills added successfully');
      this.snackBar.open('Bills added successfully!', 'Close', {
        duration: 3000, // Duration in milliseconds
      });
      this.loadBills();
      // You can update UI or perform other actions on successful addition
    });
  }

  getDisplayedBills(): any[] {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    return this.billsData.slice(startIndex, endIndex);
  }

  deleteBill(billId: number): void {
    this.maintenanaceService.deleteBill(billId).subscribe(() => {
      // Assuming you want to refresh the product list after deletion
      this.snackBar.open('Product deleted successfully!', 'Close', {
        duration: 3000, // Duration in milliseconds
      });
      this.loadBills();
    });
  }
}
