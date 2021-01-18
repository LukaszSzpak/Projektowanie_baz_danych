import {Admin, Resource} from 'react-admin'
import simpleRestProvider from 'ra-data-simple-rest'
import EmployeeCreate from './EmployeeCreate'
import EmployeeEdit from './EmployeeEdit'
import EmployeeList from './EmployeeList'

export default function UserAdminPanel() {

    return(
        <Admin dataProvider={simpleRestProvider('http://localhost:8080/api')}>
            <Resource name="employees" list={EmployeeList} create={EmployeeCreate} edit={EmployeeEdit}/>
        </Admin>    
    )
}