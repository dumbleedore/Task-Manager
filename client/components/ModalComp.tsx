import {   Modal,
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

export const ModalComp: React.FC<modalProps> = (props) => {
  return (
    <Modal isOpen={props.isOpen} onClose={props.onClose}>
    <ModalOverlay />
    <ModalContent>
      <ModalHeader>Update Task</ModalHeader>
      <ModalCloseButton />
      <ModalBody>
        <Stack>
          <Input
          value={props.nome}
            placeholder="Task Name"
          />
          <Textarea
          value={props.descricao}
            placeholder="Task Description"
          />
          <Input
          value={props.data}
            placeholder="Select Date"
            type="date"
          />
        </Stack>
      </ModalBody>
      <ModalFooter>
        <Button  colorScheme="blue">
          Update
        </Button>
      </ModalFooter>
    </ModalContent>
  </Modal>
  )
}
