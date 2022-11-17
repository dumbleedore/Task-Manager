import {   
    Modal,
    ModalBody,
    ModalCloseButton,
    ModalContent,
    ModalFooter,
    Button,
    ModalHeader,
    Stack,
    Input,
    Textarea,
    ModalOverlay,
   } from '@chakra-ui/react';
import React from 'react'
import modalProps from '../interface/modalProps';
import Task from '../interface/task';
import { createTask, updateTask } from '../services/services';
export const ModalComp: React.FC<modalProps> = (props) => {
  const [form, setForm] = React.useState<Task>({
    id: props.id,
    nome: props.nome,
    descricao: props.descricao,
    status: props.status,
    data: props.data,
  });
  const handleClick = async () => {
    if(!props.isCreate){
      await updateTask(props.id,form);
      window.location.reload();
      return;
    }
    await createTask(form);
  }
  return (
    <Modal isOpen={props.isOpen} onClose={props.onClose}>
    <ModalOverlay />
    <ModalContent>
      <ModalHeader>{props.isCreate ? "Create Task" : "Update Task"}</ModalHeader>
      <ModalCloseButton />
      <ModalBody>
        <Stack>
          <Input
          defaultValue={props.isCreate ? "" : props.nome}
          onChange={(event) => {
            setForm({ ...form, nome: event.target.value });
          }}
            placeholder="Task Name"
          />
          <Textarea
          defaultValue={props.isCreate ? "" : props.descricao}
          onChange={(event) => {
            setForm({ ...form, descricao: event.target.value });
          }}
            placeholder="Task Description"
          />
          <Input
          defaultValue={props.isCreate ? "" : props.data}
          onChange={(event) => {
            setForm({ ...form, data: event.target.value });
          }}
            placeholder="Select Date"
            type="date"
          />
        </Stack>
      </ModalBody>
      <ModalFooter>
        <Button onClick={handleClick}  colorScheme="blue">
          {props.isCreate ? "Create Task" : "Update Task"}
        </Button>
      </ModalFooter>
    </ModalContent>
  </Modal>
  )
}
