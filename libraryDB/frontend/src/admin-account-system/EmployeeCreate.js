import React from 'react'
import {Create, SimpleForm, TextInput, SelectInput } from 'react-admin'

export default function AccountCreate(props) {

    return(
        <Create title='Create account' {...props}>
            <SimpleForm>
                <TextInput source='name'/>
                <TextInput source='surname'/>
                <TextInput source='email'/>
                <SelectInput source="category" choices={[
                    { id: 'admin', name: 'admin' },
                    { id: 'librarian', name: 'librarian' },
                ]} />
            </SimpleForm>
        </Create>
    );
}