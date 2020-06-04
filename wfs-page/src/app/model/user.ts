export interface User {
  id: bigint;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  userType: string;
  companyId: bigint;
}
