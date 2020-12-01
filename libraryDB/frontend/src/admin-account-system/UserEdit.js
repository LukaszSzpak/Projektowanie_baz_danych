import React, { useContext } from 'react'
import {Edit, SimpleForm, TextInput, SelectInput } from 'react-admin'
import roleContext from '../RoleContext'

export default function UserEdit(props) {

    return(
        <Edit title='Edit account' {...props}>
            <SimpleForm>
                <TextInput source='name'/>
                <TextInput source='surname'/>
                <TextInput source='email'/>
                <TextInput source='password'/>
            </SimpleForm>
        </Edit>
    );
}