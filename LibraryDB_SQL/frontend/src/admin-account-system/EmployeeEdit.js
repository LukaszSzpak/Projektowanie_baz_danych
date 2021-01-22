import React from 'react'
import {Edit, SimpleForm, TextInput, SelectInput } from 'react-admin'

export default function AccountEdit(props) {

    return(
        <Edit title='Edit account' {...props}>
            <SimpleForm>
                <TextInput source='id'/>
                <TextInput source='name'/>
                <TextInput source='surname'/>
                <TextInput source='email'/>
                <SelectInput source="role" choices={[
                    { id: 'ADMIN', name: 'ADMIN' },
                    { id: 'LIBRARIAN', name: 'LIBRARIAN' },
                ]} />
            </SimpleForm>
        </Edit>
    );
}