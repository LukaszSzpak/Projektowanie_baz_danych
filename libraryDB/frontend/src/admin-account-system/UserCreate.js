import React, {useContext} from 'react'
import {Create, SimpleForm, TextInput, SelectInput } from 'react-admin'
import roleContext from './RoleContext'

export default function AccountCreate(props) {

    return(
        <Create title='Create account' {...props}>
            <SimpleForm>
                <TextInput source='id'/>
                <TextInput source='name'/>
                <TextInput source='surname'/>
                <TextInput source='email'/>
            </SimpleForm>
        </Create>
    );
}