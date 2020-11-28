import React, { useContext } from 'react'
import {Edit, SimpleForm, TextInput, SelectInput } from 'react-admin'
import roleContext from './RoleContext'

export default function AccountEdit(props) {

    return(
        <Edit title='Edit account' {...props}>
            <SimpleForm>
                <TextInput source='id'/>
                <TextInput source='name'/>
                <TextInput source='surname'/>
                <TextInput source='email'/>
            </SimpleForm>
        </Edit>
    );
}