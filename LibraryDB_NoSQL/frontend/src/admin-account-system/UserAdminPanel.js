import {Admin, Resource} from 'react-admin'
import simpleRestProvider from 'ra-data-simple-rest'
import UserList from './UserList'
import UserCreate from './UserCreate'
import UserEdit from './UserEdit'

export default function UserAdminPanel() {

    return(
        <Admin dataProvider={simpleRestProvider('http://localhost:8080/api')}>
            <Resource name="users" list={UserList} create={UserCreate} edit={UserEdit}/>
        </Admin>    
    )
}