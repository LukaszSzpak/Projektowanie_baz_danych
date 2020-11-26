import React, { useContext } from 'react'
import {Edit, SimpleForm, TextInput, SelectInput } from 'react-admin'
import roleContext from './RoleContext'

export default function AccountEdit(props) {

    const userRole = useContext(roleContext);

    return(
        <Edit title='Edit account' {...props}>
            <SimpleForm>
                <TextInput source='id'/>
                <TextInput source='name'/>
                <TextInput source='surname'/>
                <TextInput source='email'/>
                { userRole==='admin' &&
                    <SelectInput source='role' choices={
                        [
                            {id: 'user', name: 'user'},
                            {id: 'librarian', name: 'librarian'},
                            {id: 'admin', name: 'admin'},
                        ]
                    }/>
                }
            </SimpleForm>
        </Edit>
    );
}