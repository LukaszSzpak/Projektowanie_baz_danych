import React from 'react'
import {Create, SimpleForm, TextInput, SelectInput } from 'react-admin'

export default function BookCreate(props) {

    return(
        <Create title='Create book' {...props}>
            <SimpleForm>
                <TextInput source='title'/>
                <TextInput source='author'/>
                <TextInput source='description'/>
            </SimpleForm>
        </Create>
    );
}