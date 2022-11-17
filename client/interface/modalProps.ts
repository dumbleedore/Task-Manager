import Task from "./task";
export default interface modalProps extends Task{
    isOpen : boolean;
    onClose : () => void;
    onOpen : () => void;
}