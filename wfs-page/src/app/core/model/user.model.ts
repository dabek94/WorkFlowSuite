import {Address} from './address.model';
import {Company} from './company.model';

export class User {
  constructor(
    public id?: bigint,
    public token?: string,
    public email?: string,
    public password?: string,
    public firstName?: string,
    public lastName?: string,
    public userType?: string,
    public address?: Address,
    public company?: Company
  ) {
  }

}
