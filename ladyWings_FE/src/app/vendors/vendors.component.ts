import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SharedDataServiceService } from '../shared-data-service.service';

@Component({
  selector: 'app-vendors',
  templateUrl: './vendors.component.html',
  styleUrls: ['./vendors.component.css']
})
export class VendorsComponent implements OnInit {

  vendor: any =this.sharedDataServiceService.getDefaultVendor();
  vendors: any[] = [];
  pageSize = 5; // Number of items per page
  currentPage = 1;
  constructor(private vendorService: VendorService,private snackBar: MatSnackBar,private  sharedDataServiceService:SharedDataServiceService) {}

  loadVendors(): void {
    this.vendorService.getVendors().subscribe((data) => {
      this.vendors = data;
    });
  }
  getDisplayedVendors(): any[] {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    return this.vendors.slice(startIndex, endIndex);
  }
  
  addVendor() {
    this.vendorService.addVendor([this.vendor]).subscribe(response => {
      console.log('Vendor added successfully');
      this.snackBar.open('Vendor added successfully!', 'Close', {
        duration: 3000, // Duration in milliseconds
      });
      this.loadVendors();
      console.log(this.vendors);
    });
  }

  ngOnInit(): void {
    this.vendorService.getVendors().subscribe(data => {
      this.vendors = data;
      console.log('Vendors received:', this.vendor);
    });
    this.loadVendors();
  }
  deleteVendor(vendorId: number): void {
    this.vendorService.deleteVendor(vendorId).subscribe(() => {
      // Assuming you want to refresh the product list after deletion
      this.snackBar.open('Vendor deleted successfully!', 'Close', {
        duration: 3000, // Duration in milliseconds
      });
      this.loadVendors();
    });
  }
  
  onPageChange(event: any): void {
    this.currentPage = event.pageIndex + 1;
  }

}
