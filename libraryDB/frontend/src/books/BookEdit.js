import React, { useContext } from 'react'
import {Edit, SimpleForm, TextInput, SelectInput } from 'react-admin'

export default function BookEdit(props) {

    return(
        <Edit title='Edit book' {...props}>
            <SimpleForm>
                <TextInput source='id'/>
                <TextInput source='title'/>
                <TextInput source='author'/>
                <TextInput source='description'/>
                <TextInput source='avalible'/>
            </SimpleForm>
        </Edit>
    );
}