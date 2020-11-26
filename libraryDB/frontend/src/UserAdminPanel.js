import {Admin, Resource} from 'react-admin'
import restProvider from 'ra-data-simple-rest'
import UserList from './UserList'
import AccountCreate from './AccountCreate'
import AccountEdit from './AccountEdit'

export default function UserAdminPanel() {

    return(
        <Admin dataProvider={restProvider('http://localhost:8080/api')}>
            <Resource name="users" list={UserList} create={AccountCreate} edit={AccountEdit}/>
        </Admin>    
    )
}