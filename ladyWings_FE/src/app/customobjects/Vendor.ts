export interface Vendor {
  vendorName: string;
  vendorCompany: string;
  vendorId: string;
  vendorAddress: {
    addressLine1: string;
    addressLine2: string;
    city: string;
    state: string;
    country: string;
    pincode: string;
  };
  vendorContactDetails: {
    contactDetailsId: number | null;
    phoneNumber: string;
    email: string;
  };
}