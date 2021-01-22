import React from 'react'
import {Create, SimpleForm, TextInput, SelectInput } from 'react-admin'

export default function UserCreate(props) {

    return(
        <Create title='Create account' {...props}>
            <SimpleForm>
                <TextInput source='name'/>
                <TextInput source='surname'/>
                <TextInput source='email'/>
                <TextInput source='password'/>
                <SelectInput source="role" choices={[
                    { id: 'ADMIN', name: 'ADMIN' },
                    { id: 'LIBRARIAN', name: 'LIBRARIAN' }, 
                ]} />
            </SimpleForm>
        </Create>
    );
}