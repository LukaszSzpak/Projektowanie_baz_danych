import {Admin, Resource} from 'react-admin'
import restProvider from 'ra-data-simple-rest'
import UserList from './UserList'
import UserCreate from './UserCreate'
import UserEdit from './UserEdit'

export default function UserAdminPanel() {

    return(
        <Admin dataProvider={restProvider('http://localhost:8080')}>
            <Resource name="users" list={UserList} create={UserCreate} edit={UserEdit}/>
        </Admin>    
    )
}