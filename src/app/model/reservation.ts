export class Reservation {
    id : string | undefined;
    dateOfBooking? : Date;
    customer : string | undefined;
    car : string | undefined;
    dateFrom? : Date;
    dateTo? : Date;
    branchOfLoan : string | undefined;
    returnBranch : string | undefined;
    totalAmount? : number;
    warranty? : number;

}
